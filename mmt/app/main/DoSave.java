package mmt.app.main;

import java.io.IOException;

import mmt.core.TicketOffice;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

//FIXME import other classes if necessary

/**
 * §3.1.1. Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<TicketOffice> {
  
  private Input<String> _filepath;

  /**
   * @param receiver
   */
  public DoSave(TicketOffice receiver) {
    super(Label.SAVE, receiver);
    _filepath = _form.addStringInput(Message.newSaveAs());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    String datafile = System.getProperty("out");
    if (datafile == null) {
      _form.parse();
      System.setProperty("out", _filepath.value());
      datafile = _filepath.value();
    }
    try {
      _receiver.save(datafile);
    } catch (IOException e) {
      // shouldn't happen in a controlled test setup
      e.printStackTrace();
    }

  }
}
