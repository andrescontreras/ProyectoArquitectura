﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace PresentacionSOAP.ProxyMovimientos {
    using System.Runtime.Serialization;
    using System;
    
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="Movimiento", Namespace="http://schemas.datacontract.org/2004/07/LogicaFinanciera")]
    [System.SerializableAttribute()]
    public partial class Movimiento : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private PresentacionSOAP.ProxyMovimientos.Usuario UsuarioField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private bool estadoField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private System.DateTime fechaField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int id_movimientoField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int id_usuarioField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private System.Nullable<decimal> num_aprovacionField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int valorField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public PresentacionSOAP.ProxyMovimientos.Usuario Usuario {
            get {
                return this.UsuarioField;
            }
            set {
                if ((object.ReferenceEquals(this.UsuarioField, value) != true)) {
                    this.UsuarioField = value;
                    this.RaisePropertyChanged("Usuario");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public bool estado {
            get {
                return this.estadoField;
            }
            set {
                if ((this.estadoField.Equals(value) != true)) {
                    this.estadoField = value;
                    this.RaisePropertyChanged("estado");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public System.DateTime fecha {
            get {
                return this.fechaField;
            }
            set {
                if ((this.fechaField.Equals(value) != true)) {
                    this.fechaField = value;
                    this.RaisePropertyChanged("fecha");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int id_movimiento {
            get {
                return this.id_movimientoField;
            }
            set {
                if ((this.id_movimientoField.Equals(value) != true)) {
                    this.id_movimientoField = value;
                    this.RaisePropertyChanged("id_movimiento");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int id_usuario {
            get {
                return this.id_usuarioField;
            }
            set {
                if ((this.id_usuarioField.Equals(value) != true)) {
                    this.id_usuarioField = value;
                    this.RaisePropertyChanged("id_usuario");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public System.Nullable<decimal> num_aprovacion {
            get {
                return this.num_aprovacionField;
            }
            set {
                if ((this.num_aprovacionField.Equals(value) != true)) {
                    this.num_aprovacionField = value;
                    this.RaisePropertyChanged("num_aprovacion");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int valor {
            get {
                return this.valorField;
            }
            set {
                if ((this.valorField.Equals(value) != true)) {
                    this.valorField = value;
                    this.RaisePropertyChanged("valor");
                }
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="Usuario", Namespace="http://schemas.datacontract.org/2004/07/LogicaFinanciera")]
    [System.SerializableAttribute()]
    public partial class Usuario : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private PresentacionSOAP.ProxyMovimientos.Movimiento[] MovimientoField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int id_usuarioField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string nombreField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int numero_documentoField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string passwordField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int saldoField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string tipo_documentoField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public PresentacionSOAP.ProxyMovimientos.Movimiento[] Movimiento {
            get {
                return this.MovimientoField;
            }
            set {
                if ((object.ReferenceEquals(this.MovimientoField, value) != true)) {
                    this.MovimientoField = value;
                    this.RaisePropertyChanged("Movimiento");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int id_usuario {
            get {
                return this.id_usuarioField;
            }
            set {
                if ((this.id_usuarioField.Equals(value) != true)) {
                    this.id_usuarioField = value;
                    this.RaisePropertyChanged("id_usuario");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string nombre {
            get {
                return this.nombreField;
            }
            set {
                if ((object.ReferenceEquals(this.nombreField, value) != true)) {
                    this.nombreField = value;
                    this.RaisePropertyChanged("nombre");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int numero_documento {
            get {
                return this.numero_documentoField;
            }
            set {
                if ((this.numero_documentoField.Equals(value) != true)) {
                    this.numero_documentoField = value;
                    this.RaisePropertyChanged("numero_documento");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string password {
            get {
                return this.passwordField;
            }
            set {
                if ((object.ReferenceEquals(this.passwordField, value) != true)) {
                    this.passwordField = value;
                    this.RaisePropertyChanged("password");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int saldo {
            get {
                return this.saldoField;
            }
            set {
                if ((this.saldoField.Equals(value) != true)) {
                    this.saldoField = value;
                    this.RaisePropertyChanged("saldo");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string tipo_documento {
            get {
                return this.tipo_documentoField;
            }
            set {
                if ((object.ReferenceEquals(this.tipo_documentoField, value) != true)) {
                    this.tipo_documentoField = value;
                    this.RaisePropertyChanged("tipo_documento");
                }
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="ProxyMovimientos.IWSMovimientos")]
    public interface IWSMovimientos {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IWSMovimientos/DoWork", ReplyAction="http://tempuri.org/IWSMovimientos/DoWorkResponse")]
        PresentacionSOAP.ProxyMovimientos.Movimiento[] DoWork();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IWSMovimientos/DoWork", ReplyAction="http://tempuri.org/IWSMovimientos/DoWorkResponse")]
        System.Threading.Tasks.Task<PresentacionSOAP.ProxyMovimientos.Movimiento[]> DoWorkAsync();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IWSMovimientos/GetAllMovimiento", ReplyAction="http://tempuri.org/IWSMovimientos/GetAllMovimientoResponse")]
        PresentacionSOAP.ProxyMovimientos.Movimiento[] GetAllMovimiento();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IWSMovimientos/GetAllMovimiento", ReplyAction="http://tempuri.org/IWSMovimientos/GetAllMovimientoResponse")]
        System.Threading.Tasks.Task<PresentacionSOAP.ProxyMovimientos.Movimiento[]> GetAllMovimientoAsync();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IWSMovimientos/AddMovimiento", ReplyAction="http://tempuri.org/IWSMovimientos/AddMovimientoResponse")]
        int AddMovimiento(PresentacionSOAP.ProxyMovimientos.Movimiento movimiento);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IWSMovimientos/AddMovimiento", ReplyAction="http://tempuri.org/IWSMovimientos/AddMovimientoResponse")]
        System.Threading.Tasks.Task<int> AddMovimientoAsync(PresentacionSOAP.ProxyMovimientos.Movimiento movimiento);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IWSMovimientos/GetAllMovimientoById", ReplyAction="http://tempuri.org/IWSMovimientos/GetAllMovimientoByIdResponse")]
        PresentacionSOAP.ProxyMovimientos.Movimiento GetAllMovimientoById(int id);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IWSMovimientos/GetAllMovimientoById", ReplyAction="http://tempuri.org/IWSMovimientos/GetAllMovimientoByIdResponse")]
        System.Threading.Tasks.Task<PresentacionSOAP.ProxyMovimientos.Movimiento> GetAllMovimientoByIdAsync(int id);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IWSMovimientos/UpdateMovimiento", ReplyAction="http://tempuri.org/IWSMovimientos/UpdateMovimientoResponse")]
        int UpdateMovimiento(PresentacionSOAP.ProxyMovimientos.Movimiento movimiento);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IWSMovimientos/UpdateMovimiento", ReplyAction="http://tempuri.org/IWSMovimientos/UpdateMovimientoResponse")]
        System.Threading.Tasks.Task<int> UpdateMovimientoAsync(PresentacionSOAP.ProxyMovimientos.Movimiento movimiento);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IWSMovimientos/DeleteMovimientoById", ReplyAction="http://tempuri.org/IWSMovimientos/DeleteMovimientoByIdResponse")]
        int DeleteMovimientoById(int Id);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IWSMovimientos/DeleteMovimientoById", ReplyAction="http://tempuri.org/IWSMovimientos/DeleteMovimientoByIdResponse")]
        System.Threading.Tasks.Task<int> DeleteMovimientoByIdAsync(int Id);
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface IWSMovimientosChannel : PresentacionSOAP.ProxyMovimientos.IWSMovimientos, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class WSMovimientosClient : System.ServiceModel.ClientBase<PresentacionSOAP.ProxyMovimientos.IWSMovimientos>, PresentacionSOAP.ProxyMovimientos.IWSMovimientos {
        
        public WSMovimientosClient() {
        }
        
        public WSMovimientosClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public WSMovimientosClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public WSMovimientosClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public WSMovimientosClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public PresentacionSOAP.ProxyMovimientos.Movimiento[] DoWork() {
            return base.Channel.DoWork();
        }
        
        public System.Threading.Tasks.Task<PresentacionSOAP.ProxyMovimientos.Movimiento[]> DoWorkAsync() {
            return base.Channel.DoWorkAsync();
        }
        
        public PresentacionSOAP.ProxyMovimientos.Movimiento[] GetAllMovimiento() {
            return base.Channel.GetAllMovimiento();
        }
        
        public System.Threading.Tasks.Task<PresentacionSOAP.ProxyMovimientos.Movimiento[]> GetAllMovimientoAsync() {
            return base.Channel.GetAllMovimientoAsync();
        }
        
        public int AddMovimiento(PresentacionSOAP.ProxyMovimientos.Movimiento movimiento) {
            return base.Channel.AddMovimiento(movimiento);
        }
        
        public System.Threading.Tasks.Task<int> AddMovimientoAsync(PresentacionSOAP.ProxyMovimientos.Movimiento movimiento) {
            return base.Channel.AddMovimientoAsync(movimiento);
        }
        
        public PresentacionSOAP.ProxyMovimientos.Movimiento GetAllMovimientoById(int id) {
            return base.Channel.GetAllMovimientoById(id);
        }
        
        public System.Threading.Tasks.Task<PresentacionSOAP.ProxyMovimientos.Movimiento> GetAllMovimientoByIdAsync(int id) {
            return base.Channel.GetAllMovimientoByIdAsync(id);
        }
        
        public int UpdateMovimiento(PresentacionSOAP.ProxyMovimientos.Movimiento movimiento) {
            return base.Channel.UpdateMovimiento(movimiento);
        }
        
        public System.Threading.Tasks.Task<int> UpdateMovimientoAsync(PresentacionSOAP.ProxyMovimientos.Movimiento movimiento) {
            return base.Channel.UpdateMovimientoAsync(movimiento);
        }
        
        public int DeleteMovimientoById(int Id) {
            return base.Channel.DeleteMovimientoById(Id);
        }
        
        public System.Threading.Tasks.Task<int> DeleteMovimientoByIdAsync(int Id) {
            return base.Channel.DeleteMovimientoByIdAsync(Id);
        }
    }
}
