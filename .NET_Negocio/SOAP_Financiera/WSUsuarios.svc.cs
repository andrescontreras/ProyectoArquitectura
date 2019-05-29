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
	// NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "WSUsuarios" in code, svc and config file together.
	// NOTE: In order to launch WCF Test Client for testing this service, please select WSUsuarios.svc or WSUsuarios.svc.cs at the Solution Explorer and start debugging.
	public class WSUsuarios : IWSUsuarios
	{
		private FacadeUsuarios fu = new FacadeUsuarios();
		public List<Usuario> DoWork()
		{
			return null;
		}
		public List<Usuario> GetAllUsuario()
		{
			return fu.GetUsuarios();
		}



		public Usuario GetAllUsuarioById(int id)
		{
			Usuario usuario = fu.GetUsuario(id);
			if (usuario == null)
			{
				return null;
			}

			return usuario;
		}

		public int DeleteUsuarioById(int id)
		{

			Usuario usuario = fu.DeleteUsuario(id);
			if (usuario == null)
			{
				return 0;
			}

			return usuario.id_usuario;
		}

		public int AddUsuario(Usuario item)
		{
			Usuario rusuario = fu.AddUsuario(item);

			if (rusuario == null)
			{
				return 0;
			}

			return rusuario.id_usuario;
		}
		public int UpdateUsuario(Usuario item)
		{
			Usuario rusuario = fu.EditUsuario(item);
			if (rusuario == null)
			{
				return 0;
			}
			return rusuario.id_usuario;
		}

	}
}
