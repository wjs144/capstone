package common.message;

/**
 * base class for all end-point messages in case we need to return errors to the front end
 * @author jravi
 *
 */
public class EndpointMessageBase {

	public boolean messageSuccess;
	public String[] errorMsg;
}
