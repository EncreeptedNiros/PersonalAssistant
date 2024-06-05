import java.util.ArrayList;

public class testejson {

	public ArrayList<String> keys(String seila) {

		String protophrase = "";
		int objeto = 1;
		ArrayList<String> chaves = new ArrayList<String>();		
		char[] manipulaString = seila.toCharArray();
		chaves.add("08j3t0_0");

		//loop pega chave
		for (int y = 0; y <= manipulaString.length - 1; y++) {

			
			if(manipulaString[y] == ',' && manipulaString[y+1] == '"')
			{
				for(int x = y;x <= manipulaString.length - 1;x++)
				{
					if(manipulaString[x] == '"' || manipulaString[x] == '{' || manipulaString[x] == '"' || manipulaString[x] == ',')
					{

					}
					else if (manipulaString[x] == ':' && manipulaString[x-1] == '"') 
					{
				
						chaves.add(protophrase);
						protophrase = "";
						x = manipulaString.length + 1;
					}
					else 
					{
						protophrase = protophrase + manipulaString[x];
					}
				
				}
			
			}
			else if(manipulaString[y] == '{' && manipulaString[y+1] == '"')
			{
				for(int x = y;x <= manipulaString.length - 1;x++)
				{
					if(manipulaString[x] == '"' || manipulaString[x] == '{' || manipulaString[x] == '"' || manipulaString[x] == ',')
					{

					}
					else if (manipulaString[x] == ':' && manipulaString[x-1] == '"') 
					{
				
						chaves.add(protophrase);
						protophrase = "";
						x = manipulaString.length + 1;
					}
					else 
					{
						protophrase = protophrase + manipulaString[x];
					}
				
				}
			
			}
			else if(manipulaString[y] == '}' && y+2 < manipulaString.length)
			{
				chaves.add("08j3t0_"+objeto);
				objeto = objeto+1;
			}

		}	
	
		return chaves;
	}

	public ArrayList<String> values(String seila)
	{
		String protophrase = "";
		int objeto = 1;
		ArrayList<String> valores = new ArrayList<String>();
		char[] manipulaString = seila.toCharArray();
		valores.add("08j3t0_0");


		//loop pega valor
		for(int y = 0; y <= manipulaString.length - 1; y++) 
		{
			if(manipulaString[y] == ':' && manipulaString[y-1] == '"') 
			{
				for(int x = y+1;x <= manipulaString.length - 1;x++)
				{
					if(manipulaString[x] == ',' && manipulaString[x+1] == '"' || manipulaString[x] == '}') 
					{
						valores.add(protophrase);
						protophrase = "";
						x = manipulaString.length+2;
					}
					else if(manipulaString[x] == '"' || manipulaString[x] == '}' || manipulaString[x] == '{')
					{

					}
					else 
					{
						protophrase = protophrase + manipulaString[x];
					}
				}
			}
			else if(manipulaString[y] == '}' && y+2 < manipulaString.length)
			{
				valores.add("08j3t0_"+objeto);
				objeto = objeto+1;
			}	

			
		}
		return valores;
	}
}