package mmt.app.itineraries;

import mmt.core.TicketOffice;
import mmt.app.exceptions.BadDateException;
import mmt.app.exceptions.BadTimeException;
import mmt.app.exceptions.NoSuchItineraryException;
import mmt.app.exceptions.NoSuchPassengerException;
import mmt.app.exceptions.NoSuchStationException;
import mmt.core.exceptions.BadDateSpecificationException;
import mmt.core.exceptions.BadTimeSpecificationException;
import mmt.core.exceptions.NoSuchPassengerIdException;
import mmt.core.exceptions.NoSuchStationNameException;
import mmt.core.exceptions.NoSuchItineraryChoiceException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.Form;


//FIXME import other classes if necessary

/**
 * §3.4.3. Add new itinerary.
 */
public class DoRegisterItinerary extends Command<TicketOffice> {

  private Input<Integer> _passengerId;
  private Input<String> _departureStation;
  private Input<String> _arrivalStation;
  private Input<String> _departureDate;
  private Input<String> _departureHour;
  private Input<Integer> _itineraryChoice;
  private Form _itineraryChoiceForm;

  /**
   * @param receiver
   */
  public DoRegisterItinerary(TicketOffice receiver) {
    super(Label.REGISTER_ITINERARY, receiver);
    _itineraryChoiceForm = new Form(Label.REGISTER_ITINERARY);
    _passengerId =_form.addIntegerInput(Message.requestPassengerId());
    _departureStation = _form.addStringInput(Message.requestDepartureStationName());
    _arrivalStation = _form.addStringInput(Message.requestArrivalStationName());
    _departureDate = _form.addStringInput(Message.requestDepartureDate());
    _departureHour = _form.addStringInput(Message.requestDepartureTime());

    _itineraryChoice = _itineraryChoiceForm.addIntegerInput(Message.requestItineraryChoice());

  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    try {
	_form.parse();
	String result =_receiver.searchItinerary(_departureStation.value(), _arrivalStation.value(),
		_departureDate.value(),_departureHour.value());
	if (!result.equals("\n")) {
		_display.addLine(result);
		_display.display();
		_itineraryChoiceForm.parse();
		if (_itineraryChoice.value() >= 0) {
			_receiver.commitItinerary(_passengerId.value(), _itineraryChoice.value());
		}
		else {
			throw new NoSuchItineraryException(_passengerId.value(), _itineraryChoice.value());
		}
	}
      //FIXME implement command
      // must call (at least) _receiver.searchItineraries(...) and _receiver.commitItinerary(...)
    } catch (NoSuchPassengerIdException e) {
      throw new NoSuchPassengerException(e.getId());
    } catch (NoSuchStationNameException e) {
      throw new NoSuchStationException(e.getName());
    } catch (NoSuchItineraryChoiceException e) {
      throw new NoSuchItineraryException(e.getPassengerId(), e.getItineraryId());
    } catch (BadDateSpecificationException e) {
      throw new BadDateException(e.getDate());
    } catch (BadTimeSpecificationException e) {
      throw new BadTimeException(e.getTime());
    }
  }
}
