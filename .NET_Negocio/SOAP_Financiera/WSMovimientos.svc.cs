using LogicaFinanciera;
using LogicaFinanciera.Negocio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
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
		private FacadeMovimientos fm = new FacadeMovimientos();
		public List<Movimiento> DoWork()
		{
			return null;
		}

		public List<Movimiento> GetAllMovimiento()
		{
			return fm.GetMovimientos();
		}



		public Movimiento GetAllMovimientoById(int id)
		{

			Movimiento movimiento = fm.GetMovimiento(id);
			if (movimiento == null)
			{
				return null;
			}

			return movimiento;
		}

		public int DeleteMovimientoById(int id)
		{

			Movimiento rmovimiento = fm.DeleteMovimiento(id);
			if (rmovimiento == null)
			{
				return 0;
			}
			return rmovimiento.id_movimiento;
		}

		public int AddMovimiento(Movimiento item)
		{
			Movimiento rmovimiento = fm.AddMovimiento(item);
			if (rmovimiento == null)
			{
				return 0;
			}
			return rmovimiento.id_movimiento;
		}
		public int UpdateMovimiento(Movimiento item)
		{
			Movimiento rmovimiento = fm.EditMovimiento(item);
			if (rmovimiento == null)
			{
				return 0;
			}
			return rmovimiento.id_movimiento;
		}
	}
}
