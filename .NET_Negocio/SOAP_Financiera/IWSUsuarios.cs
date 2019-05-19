using LogicaFinanciera;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace SOAP_Financiera
{
	// NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IWSUsuarios" in both code and config file together.
	[ServiceContract]
	public interface IWSUsuarios
	{
		[OperationContract]
		List<Usuario> DoWork();
		[OperationContract]
		List<Usuario> GetAllUsuario();
		[OperationContract]
		int AddUsuario(Usuario usuario);
		[OperationContract]
		Usuario GetAllUsuarioById(int id);

		[OperationContract]
		int UpdateUsuario(Usuario usuario);

		[OperationContract]
		int DeleteUsuarioById(int Id);
	}
}
