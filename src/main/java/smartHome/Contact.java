package smartHome;
import java.awt.Color;
import java.awt.event.ActionEvent;
import org.fourthline.cling.binding.annotations.*;
import java.beans.PropertyChangeSupport;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 *
 * @author Han
 */
@UpnpService(
        serviceId = @UpnpServiceId("Contact"),
        serviceType = @UpnpServiceType(value = "Contact", version = 1)
)
public class Contact extends PhoneGUI{
    private final PropertyChangeSupport propertyChangeSupport;
    private final javax.swing.JButton callButton;
    private final javax.swing.JButton cancelButton;
    private final javax.swing.JLabel labelCall;
    public Contact() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);    
        callButton=this.getCallButton();
        cancelButton=this.getCancelButton();
        labelCall=this.getLabelCall();
        callButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CallButtonActionPerformed(evt);
            }
        });
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });
    }
    private void CallButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:        
        setStatus(true);        
    }
    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        setStatus(false);
    }     
    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }    
    @UpnpStateVariable(defaultValue = "0")
    private boolean status = false;
    @UpnpAction
    public void setStatus(@UpnpInputArgument(name = "NewStatusValue")
                          boolean newTargetValue) {
        status = newTargetValue;        
        getPropertyChangeSupport().firePropertyChange("Status", null, status);
        
        if(status == true){
            labelCall.setText("IS CALLING");
            labelCall.setHorizontalAlignment(JLabel.CENTER);
            labelCall.setVerticalAlignment(JLabel.CENTER);
        }
        else if(status == false){
            labelCall.setText("NOT CALLING");
            labelCall.setHorizontalAlignment(JLabel.CENTER);
            labelCall.setVerticalAlignment(JLabel.CENTER);            
        }
    }
    @UpnpAction(out = @UpnpOutputArgument(name = "ResultStatusValue"))
    public boolean getStatus() {
        // If you want to pass extra UPnP information on error:
        // throw new ActionException(ErrorCode.ACTION_NOT_AUTHORIZED);        
        return status;
    }
}
