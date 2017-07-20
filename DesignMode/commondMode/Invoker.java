package commondMode;

/**
 * Created by pengjianzhou on 2017/7/20.
 */
public class Invoker {

    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void action(){
        this.command.execute();
    }
}
