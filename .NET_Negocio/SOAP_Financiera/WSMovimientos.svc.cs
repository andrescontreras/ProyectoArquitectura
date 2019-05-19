using LogicaFinanciera;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace SOAP_Financiera
{
	// NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "WSMovimientos" in code, svc and config file together.
	// NOTE: In order to launch WCF Test Client for testing this service, please select WSMovimientos.svc or WSMovimientos.svc.cs at the Solution Explorer and start debugging.
	public class WSMovimientos : IWSMovimientos
	{
		private FinancieraEntities db = new FinancieraEntities();
		public List<Movimiento> DoWork()
		{
			var a = db.Movimiento.ToList();

			return a;
			
	}
	}
}
