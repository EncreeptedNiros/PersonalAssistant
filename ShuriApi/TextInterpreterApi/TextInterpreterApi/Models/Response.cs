using System.ComponentModel.DataAnnotations;

namespace TextInterpreterApi.Models
{
    public class Response
    {
        [Key]
        [Required]
        public int Id { get; set; }
        [Required]
        public string responsetext { get; set; }

    }
}