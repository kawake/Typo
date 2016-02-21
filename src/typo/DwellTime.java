package typo;

import org.jnativehook.keyboard.NativeKeyEvent;

public class DwellTime
{
	private int id;
	private int masterId;
	int times[] = new int[5];
	int avgTime = 0;
	boolean first = true;
	int index;
	
	public DwellTime(int id, int masterId)
	{
		this.id = id;
		this.masterId = masterId;
		index = times.length;
	}
	
	public void receive(int time)
	{
		//check if this is the first time received
		if(!first)
		{
			for(int i = 0; i < times.length - 1; i++)
			{
				times[i] = times[i+1];
			}
			times[times.length - 1] = time;
			if(index > 0)
			{
				index -= 1;
			}
			avg();

		}
		else
		{
			times[4] = time;
			avgTime = time;
			first = false;
			index -= 1;
		}
	}
	
	private void avg()
	{
		int sum = 0;
		int count = 0;
		for(int i = times.length - 1; i >= index; i--)
		{
			sum += times[i];
			count += 1;
		}
		
		avgTime = sum/count;
	}
	
	public int getNumberKeyPresses()
	{
		return times.length - index;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getTime()
	{
		return avgTime;
	}
	
	public int validate(int time)
	{	
		//not able to check do to lack of key presses
		if(getNumberKeyPresses() <= 3)
		{
			return 2;
		}
		
		//fails the test due to range it is from average
		else if(time >= (avgTime + 15) || time <= (avgTime - 15))
		{
			return 0;
		}
		
		//Passes test
		else
			return 1;
	}
	
	public String write()
	{
		return NativeKeyEvent.getKeyText(masterId) + "," + NativeKeyEvent.getKeyText(id) + "," + avgTime;
	}
}
