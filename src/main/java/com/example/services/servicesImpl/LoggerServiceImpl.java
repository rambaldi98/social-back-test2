package com.example.services.servicesImpl;


import com.example.models.entities.Logger;
import com.example.models.dto.serviceModels.LoggerServiceModel;
import com.example.repositories.LoggerRepository;
import com.example.services.LoggerService;
import com.example.utils.constants.ResponseMessageConstants;
import com.example.utils.responseHandler.exceptions.CustomException;
import com.example.validations.serviceValidation.services.LoggerValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoggerServiceImpl implements LoggerService {
    private final ModelMapper modelMapper;
    private final LoggerRepository loggerRepository;
    private final LoggerValidationService loggerValidation;

    @Autowired
    public LoggerServiceImpl(ModelMapper modelMapper, LoggerRepository loggerRepository, LoggerValidationService loggerValidation) {
        this.loggerRepository = loggerRepository;
        this.modelMapper = modelMapper;
        this.loggerValidation = loggerValidation;
    }

    @Override
    public boolean createLog(String method, String principal, String tableName, String action) {
        if (!loggerValidation.isValid(method, principal, tableName, action)) {
            throw new CustomException(ResponseMessageConstants.FAILURE_LOGS_SAVING_MESSAGE);
        }

        LoggerServiceModel loggerServiceModel = new LoggerServiceModel();
        loggerServiceModel.setMethod(method);
        loggerServiceModel.setUsername(principal);
        loggerServiceModel.setTableName(tableName);
        loggerServiceModel.setAction(action);
        loggerServiceModel.setTime(LocalDateTime.now());

        if (!loggerValidation.isValid(loggerServiceModel)) {
            throw new CustomException(ResponseMessageConstants.FAILURE_LOGS_SAVING_MESSAGE);
        }

        Logger logger = this.modelMapper.map(loggerServiceModel, Logger.class);

        Logger savedLog = this.loggerRepository.save(logger);

        if (savedLog != null) {
            return true;
        }

        throw new CustomException(ResponseMessageConstants.FAILURE_LOGS_SAVING_MESSAGE);
    }

    @Override
    public List<LoggerServiceModel> getAllLogs() {
        return this.loggerRepository
                .findAllByOrderByTimeDesc()
                .stream()
                .map(x -> this.modelMapper.map(x, LoggerServiceModel.class))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<LoggerServiceModel> getLogsByUsername(String username) {
        if (!loggerValidation.isValid(username)) {
            throw new CustomException(ResponseMessageConstants.SERVER_ERROR_MESSAGE);
        }

        List<LoggerServiceModel> logsByUsername = this.loggerRepository
                .findAllByUsernameOrderByTimeDesc(username)
                .stream()
                .map(x -> this.modelMapper.map(x, LoggerServiceModel.class))
                .collect(Collectors.toUnmodifiableList());

        if (logsByUsername.size() == 0) {
            throw new CustomException(ResponseMessageConstants.FAILURE_LOGS_NOT_FOUND_MESSAGE);
        }

        return logsByUsername;
    }

    @Override
    public boolean deleteAll() {
        try {
            this.loggerRepository.deleteAll();
            return true;
        } catch (Exception e) {
            throw new CustomException(ResponseMessageConstants.FAILURE_LOGS_CLEARING_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean deleteByName(String username) {
        if (!loggerValidation.isValid(username)) {
            throw new CustomException(ResponseMessageConstants.SERVER_ERROR_MESSAGE);
        }

        List<Logger> loggers = this.loggerRepository.deleteAllByUsername(username);

        if (loggers.size() == 0) {
            throw new CustomException(ResponseMessageConstants.FAILURE_LOGS_NOT_FOUND_MESSAGE);
        }
        return true;
    }

////    @Scheduled(cron = "* */30 * * * *")
//    @Scheduled(cron = "0 0 2 * * * ")
//    public void testSchedule(){
//        this.deleteAll();
//        System.out.println("Logs deleted successfully!");
//    }
}


