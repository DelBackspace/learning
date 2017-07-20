/**
 * Created by pengjianzhou on 2017/7/20.
 */
public class ConcreteCommand extends Command{

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver){
        this.receiver = receiver;
    }
    public void execute() {
        this.receiver.doSomething();
    }
}
