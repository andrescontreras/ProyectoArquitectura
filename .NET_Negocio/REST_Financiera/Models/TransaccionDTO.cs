using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace REST_Financiera.Models
{
	public class TransaccionDTO
	{
		public string tipo_documento { get; set; }
		public int numero_documento { get; set; }
		public string password { get; set; }
		public int monto { get; set; }
		public bool estado { get; set; }

	}
}