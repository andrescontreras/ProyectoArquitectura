using LogicaFinanciera.Integracion;
using LogicaFinanciera.SideCar;
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

		// funciones extra

		
		/*
		 Si no encuatra el usuario retorna -1
		 Si lo encuentra retorna lo que diga la funcion descontar pago
			 */

		public int PagarRenta(TransaccionDTO transaccionDTO) {

			Usuario usuario = FindUsuario(transaccionDTO.numDocumento, transaccionDTO.password);
			if(usuario != null)
			{
				return DescontarPago(usuario, transaccionDTO.descontar);
			}
			return -1;

		}

		public Usuario FindUsuario(int documento, string password)
		{
			return i.FindUsuario(documento, password);
		}


		/*
		 Si puede descontar el pago retorna el id del usuario
		 Si no tiene fondos suficientes retorna -2;
			 */
		public int DescontarPago(Usuario usuario,int monto)
		{
			if (usuario.saldo > monto)
			{
				usuario.saldo = usuario.saldo - monto;
				EditUsuario(usuario);
				return usuario.id_usuario;
			}
			return -2;
		}

	}
}