import java.util.ArrayList;
import java.util.Scanner;

public class BaseBallDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<TeeBallPlayer> TBPlayers = new ArrayList<TeeBallPlayer>();
		ArrayList<LittleLeaguePlayer> LLPlayers = new ArrayList<LittleLeaguePlayer>();
		ArrayList<JuniorVarsityPlayer> JVPlayers = new ArrayList<JuniorVarsityPlayer>();
	
		String name, age, position = null, jerseyNumber = null, repeat = "";
		
		Scanner keyboard = new Scanner(System.in);
		
		do
		{
			//prompt for name
			System.out.print("\nName: ");
			name = keyboard.nextLine();
			
			//prompt for age and handle exception
			try
			{
				System.out.print("Age: ");
				age = keyboard.nextLine();
				if(validAge(age) == true)
				{
					if(Integer.parseInt(age) < 8)
					{
						System.out.println("Player is old enough to play Tee-Ball");
					}
					else if(Integer.parseInt(age) < 13)
					{
						System.out.println("Player is old enough to play Little League");	
					}
					else
					{
						System.out.println("Players is old enough to play Junior Varsity");
					}
				}
				
				//prompt for jersey number and handle exception
				try
				{
					System.out.print("Desired Jersey Number: ");
					jerseyNumber = keyboard.nextLine();
					if(validJersey(jerseyNumber) == true)
					{
						System.out.println("Jersey Number is valid");
					}
					
				}
				catch(JerseyNumberException e)
				{
					System.out.println(e.getMessage());
				}
				
				//prompt for the position
				try
				{
					System.out.print("Desired Position: ");
					position = keyboard.nextLine();
					if(validPosition(position, age) == true)
					{
						System.out.println("Position is valid");
					}
					
				}
				catch(PositionException e)
				{
					System.out.println(e.getMessage());
				}
				
				if(Integer.parseInt(age) < 8)
				{
					TBPlayers.add(new TeeBallPlayer(name, age, jerseyNumber, position));
				}
				else if(Integer.parseInt(age) < 13)
				{
					LLPlayers.add(new LittleLeaguePlayer(name, age, jerseyNumber, position));
				}
				else
				{
					JVPlayers.add(new JuniorVarsityPlayer(name, age, jerseyNumber, position));
				}
				
				
		}catch(AgeException e)
		{
			System.out.print(e.getMessage());
		}
			
			
		System.out.print("\nWould you like to enter another player? (Y/N): ");
		repeat = keyboard.nextLine();
			
	}while(repeat.equalsIgnoreCase("y"));
		
		//use loops to display the players
			System.out.println("\n\nTee-Ball Players\n");
			for(TeeBallPlayer p : TBPlayers)
			{
				System.out.println(p.display());
			}
			
			System.out.println("\n\nLittle League Players\n");
			for(LittleLeaguePlayer p : LLPlayers)
			{
				System.out.println(p.display());
			}
			
			System.out.println("\n\nJunior Varsity Players\n");
			for(JuniorVarsityPlayer p : JVPlayers)
			{
				System.out.println(p.display());
			}
		
	}

	public static boolean validAge(String age) throws AgeException
	{
		if(Integer.parseInt(age) < 5 || Integer.parseInt(age) > 15)
		{
			throw new AgeException("Age must be between 5 and 15 years old");
		}
		
		return true;
	}
	
	public static boolean validJersey(String jerseyNumber) throws JerseyNumberException
	{
		if(Integer.parseInt(jerseyNumber) < 0 || Integer.parseInt(jerseyNumber) > 99)
		{
			throw new JerseyNumberException("Jersey Number is invalid");
		}
		
		return true;
	}
	
	public static boolean validPosition(String position, String age) throws PositionException
	{
		if(position.length() < 1 || position.length() > 2) 
		{
			throw new PositionException("Invalid Position");
		}
	
		if(Integer.parseInt(age) < 8)
		{
			if(!position.equalsIgnoreCase("1B") &&
					!position.equalsIgnoreCase("2B") &&
					!position.equalsIgnoreCase("3B") &&
					!position.equalsIgnoreCase("C") &&
					!position.equalsIgnoreCase("LF") &&
					!position.equalsIgnoreCase("CF") &&
					!position.equalsIgnoreCase("RF") &&
					!position.equalsIgnoreCase("SS"))
			{
				throw new PositionException("Not a valid position for Tee-Ball");
			}
		}
		else
		{
			if(!position.equalsIgnoreCase("1B") &&
					!position.equalsIgnoreCase("2B") &&
					!position.equalsIgnoreCase("3B") &&
					!position.equalsIgnoreCase("C") &&
					!position.equalsIgnoreCase("LF") &&
					!position.equalsIgnoreCase("CF") &&
					!position.equalsIgnoreCase("RF") &&
					!position.equalsIgnoreCase("SS") &&
					!position.equalsIgnoreCase("P"))
			{
				throw new PositionException("Not a valid position for this league");
			}
		}
		
		return true;
		
	}
	
}

