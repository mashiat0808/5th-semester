public class Application implements HelpHandler {
    private Topic topic;

    public Application(Topic topic) {
        this.topic = topic;
    }

    @Override
    public boolean hasHelp() {
        return topic.getTopicId() != Topic.NO_HELP_TOPIC;
    }

    @Override
    public void setHandler(HelpHandler handler, Topic topic) {
        // No need
    }

    @Override
    public void handleHelp() {
        // show a list of help topics
    }


}