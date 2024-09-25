using Microsoft.AspNetCore.Mvc;
using TextInterpreterApi.Data;
using TextInterpreterApi.Models;

namespace TextInterpreterApi.Controllers;


[ApiController]
[Microsoft.AspNetCore.Mvc.Route("[controller]")]
public class InterpretationController : ControllerBase
{
    private InterpretationContext _context;
    public InterpretationController(InterpretationContext context)
    {
        _context = context;
    }

    [HttpPost]
    public void ReciveText([FromBody] Interpretation interpretation)
    {
        interpretation.saytime = DateTime.Now;
        _context.Interpretations.Add(interpretation);
        _context.SaveChanges();
        Console.WriteLine(interpretation.Id);
        Console.WriteLine(interpretation.text);
        Console.WriteLine(interpretation.saytime);
    }
    [HttpGet("{id}")]
    public IActionResult ReturnTextId(int id) 
    {
        var interpretation = _context.Interpretations.FirstOrDefault(interpretation => interpretation.Id == id);
        if (interpretation == null)
        {
            return NotFound();
        }
        return Ok(interpretation);
    }
    [HttpGet]
    public IEnumerable<Interpretation> PagText([FromQuery] int skip = 0, [FromQuery] int take = 5)
    {
        return _context.Interpretations.Skip(skip).Take(take);
    }
}
