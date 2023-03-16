public class Widget implements HelpHandler {
    private Widget parent;
    private Topic topic;

    protected Widget(Widget parent, Topic topic) {
        this.parent = parent;
        this.topic = topic;
    }

    @Override
    public boolean hasHelp() {
        return topic.getTopicId() != Topic.NO_HELP_TOPIC;
    }

    @Override
    public void setHandler(HelpHandler handler, Topic topic) {
        // This implementation is not required for this class.
    }

    @Override
    public void handleHelp() {
        if (parent != null) {
            parent.handleHelp();
        }
    }
}

class Button extends Widget {
    public Button(Widget parent, Topic topic) {
        super(parent, topic);
    }

    @Override
    public void handleHelp() {
        if (hasHelp()) {
            // offer help on the button
        } else {
            super.handleHelp();
        }
    }
}
class Dialog extends Widget {
    public Dialog(HelpHandler handler, Topic topic) {
        super(null, topic);//null instead of 0
        setHandler(handler, topic);
    }

    @Override
    public void handleHelp() {
        if (hasHelp()) {
            // offer help on the dialog
        } else {
            super.handleHelp();
        }
    }

}
