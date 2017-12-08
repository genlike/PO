package mmt.app.itineraries;

import mmt.core.TicketOffice;
import mmt.core.exceptions.NoSuchPassengerIdException;
import mmt.app.exceptions.NoSuchPassengerException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;

/**
 * §3.4.2. Show all itineraries (for a specific passenger).
 */
public class DoShowPassengerItineraries extends Command<TicketOffice> {

  private Input<Integer> _id;
  //FIXME define input fields

  /**
   * @param receiver
   */
  public DoShowPassengerItineraries(TicketOffice receiver) {
    super(Label.SHOW_PASSENGER_ITINERARIES, receiver);
     _id =_form.addIntegerInput(Message.requestPassengerId());
    //FIXME initialize input fields
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();

    try{
      _display.addLine(_receiver.showItinerariesById(_id.value()));
    } catch (NoSuchPassengerIdException pie) {
        throw new NoSuchPassengerException( _id.value());
  }
    _display.display();
    //FIXME implement command
  }

}
