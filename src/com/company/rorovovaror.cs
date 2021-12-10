using System;

namespace rorovovaror
{
	static class rovar
	{
		static string lower_consonants = "bcdghjklmnpqrstvwxz";
		static string upper_consonants = "BCFGHJKLMNPQRSTVWXZ";
		
		/// <summary>
		/// Encode the string in rovarspraket.
		/// </summary>
		/// <param name="normal">Normal string.</param>
		/// <returns>Encoded string.</returns>
		public static string enrov(string normal)
		{
			if (normal == null)
				return null;
			
			System.Text.StringBuilder builder = new System.Text.StringBuilder();
			
			foreach(char c in normal)
				if (lower_consonants.Contains(c.ToString()))
					builder.Append(c + "o" + c);
				else if (upper_consonants.Contains(c.ToString()))
					builder.Append(c + "O" + c);
				else 
					builder.Append(c);
							
			return builder.ToString();
		}
		
		
		/// <summary>
		/// Decode a string from rovarspraket.
		/// </summary>
		/// <param name="rov">Encoded string.</param>
		/// <returns>Normal string.</returns>
		public static string derov(string rov)
		{
			if (rov == null)
				return null;
			
			foreach(char c in lower_consonants)
				rov = rov.Replace(c + "o" + c, c.ToString());

			foreach(char c in upper_consonants)
				rov = rov.Replace(c + "O" + c, c.ToString());

			return rov;
		}
	}
}