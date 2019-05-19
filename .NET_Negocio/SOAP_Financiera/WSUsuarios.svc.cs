using LogicaFinanciera;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace SOAP_Financiera
{
	// NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "WSUsuarios" in code, svc and config file together.
	// NOTE: In order to launch WCF Test Client for testing this service, please select WSUsuarios.svc or WSUsuarios.svc.cs at the Solution Explorer and start debugging.
	public class WSUsuarios : IWSUsuarios
	{
		private FinancieraEntities db = new FinancieraEntities();
		public List<Usuario> DoWork()
		{
			var a = db.Usuario.ToList();

			return a;

		}
	}
}
