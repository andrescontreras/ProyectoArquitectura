using LogicaFinanciera.Integracion;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LogicaFinanciera.Negocio
{
	public class FacadeMovimientos
	{
		IntegracionMovimientos i = new IntegracionMovimientos();
		public Movimiento GetMovimiento(int id)
		{
			return i.GetMovimiento(id);
		}

		public List<Movimiento> GetMovimientos()
		{
			return i.GetMovimientos();
		}

		public Movimiento EditMovimiento(Movimiento movimiento)
		{
			return i.EditMovimiento(movimiento);
		}

		public Movimiento AddMovimiento(Movimiento movimiento)
		{
			return i.AddMovimiento(movimiento);
		}

		public Movimiento DeleteMovimiento(int id)
		{
			return i.DeleteMovimiento(id);
		}
	}
}