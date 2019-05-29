using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace PresentacionSOAP.Controllers
{
    public class UsuariosController : Controller
    {
        // GET: Usuarios
        public ActionResult Index()
        {
            return View();
        }
		public ActionResult List() {
			ProxyUsuarios.WSUsuariosClient proxy = new ProxyUsuarios.WSUsuariosClient();
			ProxyUsuarios.Usuario[] usuarios = proxy.GetAllUsuario();
			return View(usuarios.ToList());
		}

		public ActionResult Edit(int id) {

			ProxyUsuarios.WSUsuariosClient proxy = new ProxyUsuarios.WSUsuariosClient();
			var u = proxy.GetAllUsuarioById(id);
			return View(u);
		}
		[HttpPost]
		public ActionResult Edit(ProxyUsuarios.Usuario usuario)
		{

			ProxyUsuarios.WSUsuariosClient proxy = new ProxyUsuarios.WSUsuariosClient();
			var u = proxy.UpdateUsuario(usuario);
			return View();
		}

		public ActionResult Details(int id)
		{
			ProxyUsuarios.WSUsuariosClient proxy = new ProxyUsuarios.WSUsuariosClient();
			ProxyUsuarios.Usuario usuario = proxy.GetAllUsuarioById(id);
			return View(usuario);
		}

		public ActionResult Create()
		{
			ProxyUsuarios.WSUsuariosClient proxy = new ProxyUsuarios.WSUsuariosClient();
			ProxyUsuarios.Usuario[] usuarios = proxy.GetAllUsuario();
			return View(usuarios[0]);
		}
		[HttpPost]
		public ActionResult Create(ProxyUsuarios.Usuario usuario)
		{
			ProxyUsuarios.WSUsuariosClient proxy = new ProxyUsuarios.WSUsuariosClient();
			var rusuario = proxy.AddUsuario(usuario);
			return View();
		}

		public ActionResult Delete(int id)
		{
			ProxyUsuarios.WSUsuariosClient proxy = new ProxyUsuarios.WSUsuariosClient();
			ProxyUsuarios.Usuario usuario = proxy.GetAllUsuarioById(id);
			return View(usuario);
		}

		[HttpPost]
		public ActionResult Delete(ProxyUsuarios.Usuario usuario)
		{
			ProxyUsuarios.WSUsuariosClient proxy = new ProxyUsuarios.WSUsuariosClient();
			int rusuario = proxy.DeleteUsuarioById(usuario.id_usuario);
			return View(usuario);
		}
	}
}