using Microsoft.AspNetCore.Mvc;
using TextInterpreterApi.Data;
using TextInterpreterApi.Models;

namespace TextInterpreterApi.Controllers;


[ApiController]
[Microsoft.AspNetCore.Mvc.Route("[controller]")]
public class AgendaController : ControllerBase
{

    private AgendaContext _context;
    public AgendaController(AgendaContext context)
    {
        _context = context;
    }   

    [HttpPost]
    public void ReciveTask([FromBody] Agenda agenda)
    {
        _context.Agendas.Add(agenda);
        _context.SaveChanges();
        Console.WriteLine(agenda.Id);
        Console.WriteLine(agenda.task);
        Console.WriteLine(agenda.taskdate);
    }
    [HttpGet("{id}")]
    public IActionResult ReturnText(int id) 
    {
        var agenda = _context.Agendas.FirstOrDefault(agenda => agenda.Id == id);
        if(agenda == null) 
        {
            return NotFound();
        }
        return Ok(agenda);
    }
    [HttpGet]
    public IEnumerable<Agenda> PagText([FromQuery] int skip = 0, [FromQuery] int take = 5)
    {
        return _context.Agendas.Skip(skip).Take(take);
    }
}
