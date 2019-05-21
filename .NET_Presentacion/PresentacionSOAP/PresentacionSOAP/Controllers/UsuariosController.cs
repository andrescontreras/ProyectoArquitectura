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

		public ActionResult Edit() {
			ProxyUsuarios.WSUsuariosClient proxy = new ProxyUsuarios.WSUsuariosClient();
			ProxyUsuarios.Usuario[] usuarios = proxy.GetAllUsuario();
			return View(usuarios[0]);
		}

		public ActionResult Details()
		{
			ProxyUsuarios.WSUsuariosClient proxy = new ProxyUsuarios.WSUsuariosClient();
			ProxyUsuarios.Usuario[] usuarios = proxy.GetAllUsuario();
			return View(usuarios[0]);
		}
	}
}