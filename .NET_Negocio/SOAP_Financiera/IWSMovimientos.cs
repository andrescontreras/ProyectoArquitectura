﻿using LogicaFinanciera;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace SOAP_Financiera
{
	// NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IWSMovimientos" in both code and config file together.
	[ServiceContract]
	public interface IWSMovimientos
	{
		[OperationContract]
		List<Movimiento> DoWork();
		[OperationContract]
		List<Movimiento> GetAllMovimiento();
		[OperationContract]
		int AddMovimiento(Movimiento movimiento);
		[OperationContract]
		Movimiento GetAllMovimientoById(int id);

		[OperationContract]
		int UpdateMovimiento(Movimiento movimiento);

		[OperationContract]
		int DeleteMovimientoById(int Id);
	}
}
