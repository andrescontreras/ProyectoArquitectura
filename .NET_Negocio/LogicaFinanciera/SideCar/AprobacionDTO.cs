using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LogicaFinanciera.SideCar
{
	public class AprobacionDTO
	{
		public int? numAprobacion { get; set; }
		public DateTime fechaAprobacion { get; set; }
		public int estado { get; set; }
	}
}