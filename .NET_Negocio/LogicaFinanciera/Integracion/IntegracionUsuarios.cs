using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Web;

namespace LogicaFinanciera.Integracion
{
	public class IntegracionUsuarios
	{
		private FinancieraEntities db = new FinancieraEntities();

		public List<Usuario> GetUsuarios()
		{
			List<Usuario> usuarios = new List<Usuario>();
			foreach (var item in db.Usuario)
			{
				Usuario u = new Usuario();
				u.id_usuario = item.id_usuario;
				u.nombre = item.nombre;
				u.numero_documento = item.numero_documento;
				u.password = item.password;
				u.saldo = item.saldo;
				u.tipo_documento = item.tipo_documento;
				usuarios.Add(u);
			}
			return usuarios;
		}

		public Usuario GetUsuario(int id)
		{
			Usuario usuario = db.Usuario.Find(id);
			if (usuario != null)
			{
				Usuario u = new Usuario();
				u.id_usuario = usuario.id_usuario;
				u.nombre = usuario.nombre;
				u.numero_documento = usuario.numero_documento;
				u.password = usuario.password;
				u.saldo = usuario.saldo;
				u.tipo_documento = usuario.tipo_documento;
				return u;
			}
			return null;
			
		}

		public Usuario FindUsuario(int documento, string password) {

			Usuario usuario = db.Usuario
				.Where(s => s.numero_documento == documento && s.password == password)
				.FirstOrDefault();
			return usuario;
		}

		public Usuario EditUsuario(Usuario usuario)
		{
			db.Entry(usuario).State = EntityState.Modified;

			try
			{
				db.SaveChanges();
				return usuario;
			}
			catch (DbUpdateConcurrencyException)
			{
				throw;
			}
		}

		public Usuario AddUsuario(Usuario usuario)
		{

			db.Usuario.Add(usuario);
			try
			{
				db.SaveChanges();
				return usuario;
			}
			catch (DbUpdateConcurrencyException)
			{
				throw;
			}
		}

		public Usuario DeleteUsuario(int id)
		{
			Usuario usuario = db.Usuario.Find(id);
			if (usuario == null)
			{
				return null;
			}

			db.Usuario.Remove(usuario);
			try
			{
				db.SaveChanges();
				return usuario;
			}
			catch (DbUpdateConcurrencyException)
			{
				throw;
			}
		}

	}
}