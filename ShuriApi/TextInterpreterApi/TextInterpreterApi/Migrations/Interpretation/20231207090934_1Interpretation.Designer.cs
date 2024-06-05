﻿// <auto-generated />
using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using TextInterpreterApi.Data;

#nullable disable

namespace TextInterpreterApi.Migrations.Interpretation
{
    [DbContext(typeof(InterpretationContext))]
    [Migration("20231207090934_1Interpretation")]
    partial class _1Interpretation
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "6.0.11")
                .HasAnnotation("Relational:MaxIdentifierLength", 64);

            modelBuilder.Entity("TextInterpreterApi.Models.Interpretation", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    b.Property<DateTime>("saytime")
                        .HasColumnType("datetime(6)");

                    b.Property<string>("text")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.HasKey("Id");

                    b.ToTable("Interpretations");
                });
#pragma warning restore 612, 618
        }
    }
}
