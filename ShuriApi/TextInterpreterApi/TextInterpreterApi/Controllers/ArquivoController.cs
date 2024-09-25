using Microsoft.AspNetCore.Mvc;
using TextInterpreterApi.Data;
using TextInterpreterApi.Models;

namespace TextInterpreterApi.Controllers;


[ApiController]
[Microsoft.AspNetCore.Mvc.Route("[controller]")]
public class ArquivoController : ControllerBase
{
    private ArquivoContext _context;
    public ArquivoController(ArquivoContext context)
    {
        _context = context;
    }

    [HttpPost]
    public void ReciveText([FromBody] Arquivo arquivo)
    {
        _context.Arquivos.Add(arquivo);
        _context.SaveChanges();
        Console.WriteLine(arquivo.URL);
        Console.WriteLine(arquivo.nome);
        Console.WriteLine(arquivo.tipo);
    }
    [HttpGet("{nome}")]
    public IActionResult ReturnText(String url)
    {
        var arquivo = _context.Arquivos.FirstOrDefault(arquivo => arquivo.URL == url);
        if (arquivo == null) 
        {
            return NotFound();
        }
        return Ok(arquivo);
    }
    [HttpGet]
    public IEnumerable<Arquivo> PagText([FromQuery] int skip = 0, [FromQuery] int take = 5)
    {
        return _context.Arquivos.Skip(skip).Take(take);
    }
}
