using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Web;

namespace LogicaFinanciera.Integracion
{
	public class IntegracionMovimientos
	{
		private FinancieraEntities db = new FinancieraEntities();

		public List<Movimiento> GetMovimientos()
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

		public Movimiento GetMovimiento(int id)
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

		public Movimiento EditMovimiento(Movimiento item)
		{
			Movimiento movimiento = new Movimiento();
			movimiento.id_usuario = item.id_usuario;
			movimiento.id_movimiento = item.id_movimiento;
			movimiento.fecha = item.fecha;
			movimiento.estado = item.estado;
			movimiento.valor = item.valor;
			movimiento.num_aprovacion = item.num_aprovacion;
			db.Entry(movimiento).State = EntityState.Modified;

			try
			{
				db.SaveChanges();
				return movimiento;
			}
			catch (DbUpdateConcurrencyException)
			{
				throw;
			}
		}

		public Movimiento AddMovimiento(Movimiento item)
		{

			Movimiento movimiento = new Movimiento();
			movimiento.id_usuario = item.id_usuario;
			movimiento.id_movimiento = item.id_movimiento;
			movimiento.fecha = item.fecha;
			movimiento.estado = item.estado;
			movimiento.valor = item.valor;
			movimiento.num_aprovacion = item.num_aprovacion;
			db.Movimiento.Add(movimiento);
			try
			{
				db.SaveChanges();
				return movimiento;
			}
			catch (DbUpdateConcurrencyException)
			{
				throw;
			}
		}

		public Movimiento DeleteMovimiento(int id)
		{
			Movimiento movimiento = new Movimiento();
			movimiento.id_movimiento = id;
			db.Entry(movimiento).State = EntityState.Deleted;

			db.Movimiento.Remove(movimiento);
			try
			{
				db.SaveChanges();
				return movimiento;
			}
			catch (DbUpdateConcurrencyException)
			{
				throw;
			}
		}
	}
}