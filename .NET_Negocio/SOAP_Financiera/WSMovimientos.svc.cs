using LogicaFinanciera;
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
		private FinancieraEntities db = new FinancieraEntities();
		public List<Movimiento> DoWork()
		{
			return null;
		}

		public List<Movimiento> GetAllMovimiento()
		{
			var dbMovimietnos = db.Movimiento.ToList();
			List<Movimiento> movimientos = new List<Movimiento>();
			foreach (var item in dbMovimietnos)
			{
				Movimiento m = new Movimiento();
				m.id_usuario = item.id_usuario;
				m.id_movimiento = item.id_movimiento;
				m.fecha = item.fecha;
				m.estado = item.estado;
				m.valor = item.valor;
				m.num_aprovacion = item.num_aprovacion;
				movimientos.Add(m);
			}
			return movimientos;
		}



		public Movimiento GetAllMovimientoById(int id)
		{

			var movimientos = from k in db.Movimiento where k.id_movimiento == id select k;
			Movimiento movimiento = new Movimiento();
			foreach (var item in movimientos)
			{

				movimiento.id_usuario = item.id_usuario;
				movimiento.id_movimiento = item.id_movimiento;
				movimiento.fecha = item.fecha;
				movimiento.estado = item.estado;
				movimiento.valor = item.valor;
				movimiento.num_aprovacion = item.num_aprovacion;
			}

			return movimiento;
		}

		public int DeleteMovimientoById(int Id)
		{

			Movimiento movimiento = new Movimiento();
			movimiento.id_movimiento = Id;
			db.Entry(movimiento).State = EntityState.Deleted;
			int Retval = db.SaveChanges();
			return Retval;
		}

		public int AddMovimiento(Movimiento item)
		{
			Movimiento movimiento = new Movimiento();
			movimiento.id_usuario = item.id_usuario;
			movimiento.id_movimiento = item.id_movimiento;
			movimiento.fecha = item.fecha;
			movimiento.estado = item.estado;
			movimiento.valor = item.valor;
			movimiento.num_aprovacion = item.num_aprovacion;
			db.Movimiento.Add(movimiento);
			int Retval = db.SaveChanges();
			return Retval;
		}
		public int UpdateMovimiento(Movimiento item)
		{
			Movimiento movimiento = new Movimiento();
			movimiento.id_usuario = item.id_usuario;
			movimiento.id_movimiento = item.id_movimiento;
			movimiento.fecha = item.fecha;
			movimiento.estado = item.estado;
			movimiento.valor = item.valor;
			movimiento.num_aprovacion = item.num_aprovacion;
			db.Entry(movimiento).State = EntityState.Modified;

			int Retval = db.SaveChanges();
			return Retval;
		}

	}
}
