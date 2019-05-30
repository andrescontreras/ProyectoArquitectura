using LogicaFinanciera.Integracion;
using LogicaFinanciera.SideCar;
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

		// funciones extra
		public AprobacionDTO generarMovimientoExitoso(int idUsuario,int monto) {
			Movimiento movimiento = new Movimiento();
			Random randObj = new Random();
			movimiento.estado = true;
			movimiento.id_usuario = idUsuario;
			movimiento.num_aprovacion = randObj.Next(1001, 10000);
			movimiento.valor = monto;
			movimiento.fecha = DateTime.Now;

			AddMovimiento(movimiento);
			AprobacionDTO aprobacionDTO = new AprobacionDTO();
			aprobacionDTO.estado = 2;
			aprobacionDTO.fechaAprovacion = movimiento.fecha;
			aprobacionDTO.numAProvacion = movimiento.num_aprovacion;

			return aprobacionDTO; ;
		}
	}
}