package common.message;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessageBase {
	public boolean messageSuccess;
	public List<String> errorMsg;
	
	public ErrorMessageBase() {
		errorMsg = new ArrayList<String>();
		messageSuccess = true;
	}
}
