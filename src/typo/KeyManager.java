package typo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


//Global key listener libraries
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


public class KeyManager
{
	ArrayList<Key> keys;
	Key k;
	
	Key currPressed;
	Key lastReleased;
	
	static int numberOfCheckedKeyPresses = 30;
	static int[] checkedKeyPresses = new int[numberOfCheckedKeyPresses];
	static int count = 0;
	public static boolean validate = false;
	public static long timeOfLastKeyPress = System.currentTimeMillis();
	
	static Key lastKeyReleased;
	Key currKeyReleased;

	//Key lastKeyPressed;
	public int keysPressed = 0;
	private String user;
	boolean hasNextKeyTyped;
	public boolean f1Pressed = false;
	
	public KeyManager(String user, boolean newUser)
	{
		keys = new ArrayList<Key>();
		this.user = user;
		
		if(newUser)
		{
			//Adds all of the keys to ArrayList<Key> keys
			k = new Key(NativeKeyEvent.VC_A);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_B);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_C);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_D);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_E);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_F);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_G);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_H);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_I);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_J);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_K);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_L);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_M);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_N);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_O);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_P);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_Q);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_R);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_S);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_T);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_U);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_V);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_W);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_X);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_Y);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_Z);
			keys.add(k);	
			k = new Key(NativeKeyEvent.VC_SPACE);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_ENTER);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_COMMA);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_PERIOD);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_SHIFT_L);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_SHIFT_R);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_SEMICOLON);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_BACKSPACE);
			keys.add(k);;
			k = new Key(NativeKeyEvent.VC_0);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_1);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_2);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_3);
			keys.add(k);;
			k = new Key(NativeKeyEvent.VC_4);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_5);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_6);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_7);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_8);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_9);
			keys.add(k);
		}
		else
		{
			loadKeyData();
		}

	
	}
	
	private void loadKeyData()
	{
		//Adds all of the keys to ArrayList<Key> keys
		k = new Key(NativeKeyEvent.VC_A, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_B, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_C, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_D, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_E, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_F, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_G, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_H, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_I, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_J, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_K, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_L, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_M, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_N, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_O, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_P, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_Q, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_R, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_S, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_T, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_U, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_V, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_W, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_X, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_Y, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_Z, user);
		keys.add(k);	
		k = new Key(NativeKeyEvent.VC_SPACE, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_ENTER, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_COMMA, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_PERIOD, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_SHIFT_L, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_SHIFT_R, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_SEMICOLON, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_BACKSPACE, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_0, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_1, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_2, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_3, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_4, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_5, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_6, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_7, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_8, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_9, user);
		keys.add(k);
	}
	
	public void createListener()
	{
		 try {
	         GlobalScreen.registerNativeHook();
	         Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
	         logger.setLevel(Level.OFF);
	     }
	     catch (NativeHookException ex) {
	         System.err.println("There was a problem registering the native hook.");
	         System.err.println(ex.getMessage());

	         System.exit(1);
	     }
		 
     GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
		
			@Override
			public void nativeKeyReleased(NativeKeyEvent e)
			{
				//System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
				//currKeyReleased = new Key(e.getKeyCode());
				alertKeyReleased(e.getKeyCode());
			}
			
			@Override
			public void nativeKeyPressed(NativeKeyEvent e)
			{
				timeOfLastKeyPress = System.currentTimeMillis();
				int keyID = e.getKeyCode();
				alertKeyPressed(keyID);
				if(keyID == NativeKeyEvent.VC_F1)
				{
					f1Pressed = true;
				}
				keysPressed += 1;
				///System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
				//lastKeyReleased = currKeyReleased;
			}

			@Override
			public void nativeKeyTyped(NativeKeyEvent e)
			{
				//System.out.println("Key Typed: " + e.getKeyChar());
			}
		}
     );
	}
	
		public void alertKeyPressed(int keyCode)
		{
			if(isKeyUsed(keyCode) == false)
			{
				lastKeyReleased = k;
			}
			
			else
			{
				for(int i = 0; i < keys.size(); i++)
				{
					k = keys.get(i);
					
					if(k.getID() == keyCode)
					{
						k.pressed();
						if(lastKeyReleased != null)
						{
							lastKeyReleased.setNextKey(keyCode);
						}
						lastKeyReleased = k;
						break;
					}
				}	
			}
		}
		
		public boolean isKeyUsed(int keyCode)
		{
			boolean used = false;
			for(int i = 0; i < keys.size(); i++)
			{
				if(keyCode == keys.get(i).getID())
				{
					used = true;
				}
			}
			return used;
		}
		
		public void alertKeyReleased(int keyCode)
		{
			for(int i = 0; i < keys.size(); i++)
			{
				k = keys.get(i);
				if(k.getID() == keyCode)
				{
					k.released();
					break;
				}
			}
		}
		
		public static void validate()
		{
				double numPasses = 0;
				double numFails = 0;
			
				
				for(int i = 0; i < numberOfCheckedKeyPresses; i++)
				{
					if(checkedKeyPresses[i] == 1)
					{
						numPasses++;
					}
					else if(checkedKeyPresses[i] == 0)
					{
						numFails++;
					}
				}
				
				if(numPasses/(numberOfCheckedKeyPresses) >= .50)
				{
					int numPass = 0;
					int numFail = 0;
					
					System.out.println("Passed");
					validate = false;
					count = 0;
					numPasses = 0;
					numFails = 0;
					for(int j = 0; j < numberOfCheckedKeyPresses; j++)
					{
						if(checkedKeyPresses[j] == 1)
						{
							numPass++;
						}
						else if(checkedKeyPresses[j] == 0)
						{
							numFail++;
						}
					}
					
					System.out.println("Fails: " + numFail);
					System.out.println("Pass; " + numPass);
				}
				else
				{
					int numPass = 0;
					int numFail = 0;
					for(int j = 0; j < numberOfCheckedKeyPresses; j++)
					{
						if(checkedKeyPresses[j] == 1)
						{
							numPass++;
						}
						else if(checkedKeyPresses[j] == 0)
						{
							numFail++;
						}
					}
					
					System.out.println("Fails: " + numFail);
					System.out.println("Pass; " + numPass);
					System.out.println("Failed");
					count = 0;
					numPasses = 0;
					numFails = 0;
					Runtime rt = Runtime.getRuntime();
					
					try
					{
						Runtime.getRuntime().exec("C:\\Windows\\System32\\rundll32.exe user32.dll,LockWorkStation");
					} catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
		
		public void write()
		{
			for(Key key : keys)
			{
				key.write(user);
			}
		}
		
		public void writeBig(){
			File file = new File(user + "_Big.txt");
			try
			{
				PrintWriter writer = new PrintWriter(file);
				
				for(int i = 0; i < keys.size(); i += 1){
					ArrayList<String> lines = keys.get(i).writeBig();
					
					for(int j = 0; j < lines.size(); j += 1){
						writer.println(lines.get(j));
					}
				}
				
				writer.close();
			} catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void stop()
		{
			try
			{
				GlobalScreen.unregisterNativeHook();
			} catch (NativeHookException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
	
	

