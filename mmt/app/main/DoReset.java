package mmt.app.main;

import mmt.core.TicketOffice;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

//FIXME import other classes if necessary

/**
 * §3.1.1. Reset the ticket office.
 */
public class DoReset extends Command<TicketOffice> {
  
  //FIXME define input fields
  //private Input<Boolean> _bReset;
  /**
   * @param receiver
   */
  public DoReset(TicketOffice receiver) {
    super(Label.RESET, receiver);
    //_bReset = _form.addBooleanInput(Message.requestReset());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    //_form.parse();
    //if (_bReset.value()) {_receiver.reset();}
    _receiver.reset();
  }

}
