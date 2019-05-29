using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using LogicaFinanciera;
using LogicaFinanciera.Negocio;

namespace REST_Financiera.Controllers
{
    public class UsuariosController : ApiController
    {
		private FacadeUsuarios fu = new FacadeUsuarios();

        // GET: api/Usuarios
        public List<Usuario> GetUsuario()
        {
			return fu.GetUsuarios();
        }

        // GET: api/Usuarios/5
        [ResponseType(typeof(Usuario))]
        public IHttpActionResult GetUsuario(int id)
        {
			Usuario usuario =  fu.GetUsuario(id);
			if (usuario == null)
			{
				return NotFound();
			}

			return Ok(usuario);
		}

        // PUT: api/Usuarios/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutUsuario(Usuario usuario)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

			Usuario rusuario = fu.EditUsuario(usuario);

			if (rusuario == null)
			{
				return NotFound();
			}

			return Ok(rusuario);

        }

        // POST: api/Usuarios
        [ResponseType(typeof(Usuario))]
        public IHttpActionResult PostUsuario(Usuario usuario)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

			Usuario rusuario = fu.AddUsuario(usuario);

			if (usuario == null)
			{
				return NotFound();
			}

			return Ok(usuario);
		}

        // DELETE: api/Usuarios/5
        [ResponseType(typeof(Usuario))]
        public IHttpActionResult DeleteUsuario(int id)
        {

			Usuario usuario = fu.DeleteUsuario(id);
			if (usuario == null)
			{
				return NotFound();
			}
			return Ok(usuario);
        }
    }
}