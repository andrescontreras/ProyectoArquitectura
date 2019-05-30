using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LogicaFinanciera.SideCar
{
	public class AprobacionDTO
	{
		public int? numAProvacion { get; set; }
		public DateTime fechaAprovacion { get; set; }
		public int estado { get; set; }
	}
}