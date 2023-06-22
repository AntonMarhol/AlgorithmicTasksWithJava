package org.example.marhol.tasks.businessobjects;

public class GeneralLogic extends AbstractLogic{

    private static final String NUMBER_OF_TASKS_REGEX = "[1-3]";
    private static final String ERROR_MESSAGE = "Вы ввели недопустимое значение";
    private static final String TASK_SELECTION_MESSAGE = "Введите номер задачи от 1 до 3 или Q/q для выхода";
    private static final String START_MESSAGE = "ВСЕ РЕШЕНИЯ ЗАДАЧ В ОДНОЙ ПРОГРАММЕ!!!!!";
    private AbstractLogic abstractLogic;

    public void start() {
        printer.printLineBeforeText(START_MESSAGE);
        while (true) {
            printer.printLineBeforeText(TASK_SELECTION_MESSAGE);
            String chosenSolution = reader.scanNewString();
            if (inspector.checkForExitSignal(chosenSolution)) {
                printer.printBuyMessage();
                break;
            }
            else if (inspector.checkIfRegexMatches(chosenSolution, NUMBER_OF_TASKS_REGEX)) {
                switch (reader.readNumberFromString(chosenSolution)) {
                    case 1 : {
                        abstractLogic = new FirstTaskLogic();
                        break;
                    }
                    case 2 : {
                        abstractLogic = new SecondTaskLogic();
                        break;
                    }
                    case 3 : {
                        abstractLogic = new ThirdTaskLogic();
                        break;
                    }
                }
                abstractLogic.start();
            }
            else {
                printer.println(ERROR_MESSAGE);
            }
        }
    }
}