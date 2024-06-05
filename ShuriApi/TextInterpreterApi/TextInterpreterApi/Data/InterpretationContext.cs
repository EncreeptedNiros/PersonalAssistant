using TextInterpreterApi.Models;
using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations.Schema;

namespace TextInterpreterApi.Data
{
    [Table("Interpretation")]
    public class InterpretationContext : DbContext
    {
        public InterpretationContext(DbContextOptions<InterpretationContext> opts) : base(opts) 
        {
        }
        public DbSet<Interpretation> Interpretations { get; set; }
    }
}
