//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace LogicaFinanciera
{
    using System;
    using System.Collections.Generic;
    
    public partial class Movimiento
    {
        public int id_movimiento { get; set; }
        public Nullable<int> num_aprovacion { get; set; }
        public int valor { get; set; }
        public System.DateTime fecha { get; set; }
        public bool estado { get; set; }
        public int id_usuario { get; set; }
    
        public virtual Usuario Usuario { get; set; }
    }
}
