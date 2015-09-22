package by.autoServiceStation.navigation;


import by.autoServiceStation.navigation.impl.*;

public enum CommandsEnum {
    MAIN {
        @Override
        public Command createCommand() {
            return new MainCommand();
        }
    },
    ADD_CLIENT {
        @Override
        public Command createCommand() {
            return new AddClientCommand();
        }
    },
    CHECK_CLIENT {
        @Override
        public Command createCommand() {
            return new CheckClientCommand();
        }
    },
    ADD_CAR {
        @Override
        public Command createCommand() {
            return new AddCarCommand();
        }
    },
    GO_ADD_CAR {
        @Override
        public Command createCommand() {
            return new GoAddCarCommand();
        }
    },
    GO_ADD_ORDER {
        @Override
        public Command createCommand() {
            return new GoAddOrderCommand();
        }
    },
    SHOW_ORDERS {
        @Override
        public Command createCommand() {
            return new ShowOrdersCommand();
        }
    },
    MAIN_REDIRECT {
        @Override
        public Command createCommand() {
            return new RedirectCommand();
        }
    };

    public abstract Command createCommand();
}
