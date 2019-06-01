﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LogicaFinanciera.SideCar
{
	public class TransaccionDTO
	{
		public string tipoDocumento { get; set; }
		public int numDocumento { get; set; }
		public string password { get; set; }
		public int descontar { get; set; }

		// otros atributos

		public int idPropiedad { get; set; }
		public string email { get; set; }
		public DateTime fechaRenta { get; set; }
	}
}