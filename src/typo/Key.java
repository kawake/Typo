package typo;

import java.util.ArrayList;

public class Key
{
	private DwellTimeManager dManager;
	private int KeyID;
	
	private boolean pressed;
	private boolean released;
	
	private int timePressed;
	private int timeReleased;
	
	private int dwellTime = 0;
	private int FlightTime;
	
	private int nextKeyID;
	private volatile boolean keyEdgeCase;
	
	public Key(int ID)
	{ 
		KeyID = ID;
		dManager = new DwellTimeManager(ID);
	}
	
	//constructor for new user
	public Key(int ID, String user)
	{
		KeyID = ID;
		dManager = new DwellTimeManager(ID, user);
	}
	
	public int getID()
	{
		return KeyID;
	}
	
	public void pressed()
	{
		timePressed = (int)System.currentTimeMillis();
		pressed = true;
		released = false;
	}
	
	public void released()
	{
		timeReleased = (int)System.currentTimeMillis();
		getDwellTime();
		pressed = false;
		released = true;
		
		if(keyEdgeCase == true);
		{
			handleKeyPress();
			validateKey();
		}
	}
	
	public int getDwellTime()
	{
		dwellTime = (timeReleased - timePressed);
		return dwellTime;
	}
	
	public void handleKeyPress()
	{
		if(!KeyManager.validate)
		{
			dManager.pressed(nextKeyID, dwellTime);
		}
		
	}
	
	public void setNextKey(int ID)
	{
		keyEdgeCase = true;
		nextKeyID = ID;
		
		if(released == true)
		{
			handleKeyPress();
			validateKey();
			keyEdgeCase = false;
		}
		else
		{
			keyEdgeCase = true;
		}
		
	}
	
	public int getNextKey()
	{
		return nextKeyID;
	}
	
	public void validateKey()
	{
		if(KeyManager.validate)
		{
			int value = dManager.validate(nextKeyID, dwellTime);
			System.out.println(value);
			//make sure the validation worked
			if(value != 2 && KeyManager.count < KeyManager.numberOfCheckedKeyPresses)
			{
				KeyManager.checkedKeyPresses[KeyManager.count] = value; 
				KeyManager.count += 1;
				System.out.println(KeyManager.count);
			}
			
			if(KeyManager.count == KeyManager.numberOfCheckedKeyPresses)
			{
				KeyManager.validate();
			}
		}
	}
	
	public void write(String user)
	{
		dManager.write(user);
	}
	
	public ArrayList<String> writeBig(){
		return dManager.writeBig();
	}
	
}
