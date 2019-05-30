using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LogicaFinanciera.SideCar
{
	public class TransaccionDTO
	{
		public string tipo_documento { get; set; }
		public int numero_documento { get; set; }
		public string password { get; set; }
		public int monto { get; set; }

		// otros atributos

		public int idPropiedad { get; set; }
		public string email { get; set; }
		public DateTime fecha { get; set; }
	}
}