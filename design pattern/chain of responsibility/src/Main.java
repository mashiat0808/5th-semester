public class Main {
    public static void main(String[] args) {
        final Topic PRINT_TOPIC = new Topic(-1);
        final Topic PAPER_ORIENTATION_TOPIC = new Topic(2);
        final Topic APPLICATION_TOPIC = new Topic(3);

        Application application = new Application(APPLICATION_TOPIC);
        Dialog dialog = new Dialog(application, PRINT_TOPIC);
        Button button = new Button(dialog, PAPER_ORIENTATION_TOPIC);

        button.handleHelp();
    }
}