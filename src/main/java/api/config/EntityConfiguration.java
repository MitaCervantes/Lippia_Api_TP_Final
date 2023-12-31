package api.config;

import services.*;

public enum EntityConfiguration {

    TIMEENTRY {
        @Override
        public Class<?> getEntityService() {
            return TimeEntryService.class;
        }
    },
    ERROR {
        @Override
        public Class<?> getEntityService() {
            return ErrorService.class;
        }
    },
    EMPTY {
        @Override
        public Class<?> getEntityService() {
            return EmptyService.class;
        }
    };


    public abstract Class<?> getEntityService();
}
