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
		public List<Usuario> GetAllUsuario()
		{
			var dbUsuarios = db.Usuario.ToList();
			List<Usuario> usuarios = new List<Usuario>();
			foreach (var item in dbUsuarios)
			{
				Usuario u = new Usuario();
				u.id_usuario = item.id_usuario;
				u.nombre = item.nombre;
				u.numero_documento = item.numero_documento;
				u.password = item.password;
				u.saldo = item.saldo;
				usuarios.Add(u);
			}
			return usuarios;
		}



		public Usuario GetAllUsuarioById(int id)
		{

			var usuarios = from k in db.Usuario where k.id_usuario == id select k;
			Usuario usuario = new Usuario();
			foreach (var item in usuarios)
			{

				usuario.id_usuario = item.id_usuario;
				usuario.nombre = item.nombre;
				usuario.numero_documento = item.numero_documento;
				usuario.password = item.password;
				usuario.saldo = item.saldo;
			}

			return usuario;
		}

		public int DeleteUsuarioById(int Id)
		{

			Usuario usuario = new Usuario();
			usuario.id_usuario = Id;
			db.Entry(usuario).State = EntityState.Deleted;
			int Retval = db.SaveChanges();
			return Retval;
		}

		public int AddUsuario(Usuario item)
		{
			Usuario usuario = new Usuario();
			usuario.id_usuario = item.id_usuario;
			usuario.nombre = item.nombre;
			usuario.numero_documento = item.numero_documento;
			usuario.password = item.password;
			usuario.saldo = item.saldo;
			db.Usuario.Add(usuario);
			int Retval = db.SaveChanges();
			return Retval;
		}
		public int UpdateUsuario(Usuario item)
		{
			Usuario usuario = new Usuario();
			usuario.id_usuario = item.id_usuario;
			usuario.nombre = item.nombre;
			usuario.numero_documento = item.numero_documento;
			usuario.password = item.password;
			usuario.saldo = item.saldo;
			db.Entry(usuario).State = EntityState.Modified;

			int Retval = db.SaveChanges();
			return Retval;
		}

	}
}
