using LogicaFinanciera.Integracion;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LogicaFinanciera.Negocio
{
	public class FacadeUsuarios
	{
		IntegracionUsuarios i = new IntegracionUsuarios();
		public Usuario GetUsuario(int id)
		{
			return i.GetUsuario(id);
		}

		public List<Usuario> GetUsuarios()
		{
			return i.GetUsuarios();
		}

		public Usuario EditUsuario(Usuario usuario)
		{
			return i.EditUsuario(usuario);
		}

		public Usuario AddUsuario(Usuario usuario)
		{
			return i.AddUsuario(usuario);
		}

		public Usuario DeleteUsuario(int id)
		{
			return i.DeleteUsuario(id);
		}
	}
}