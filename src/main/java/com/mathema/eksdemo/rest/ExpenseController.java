package com.mathema.eksdemo.rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.mathema.eksdemo.domain.Expense;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Expense", description = "Expenses Controller")
public interface ExpenseController {

  /**
   * Operation to create an Expense 
   * @param expense - Expense
   * @return - {@link Expense}
   */
  @Operation(method = "POST",
    summary = "Create an Expense",
    description = "Make a POST request to create an Expense",
    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
      content = @Content(mediaType = "application/json",
        schema = @Schema(implementation = Expense.class))))

  public ResponseEntity<Expense> createExpense(Expense expense);

  /**
   * Operation to update an Expense 
   * @param id - Id Of Expense
   * @param expense - Expense
   * @return - {@link Expense}
   */
  @Operation(method = "PUT",
    summary = "Update an Expense",
    description = "Make a PUT request to update an Expense",
    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
      content = @Content(mediaType = "application/json",
        schema = @Schema(implementation = Expense.class))))

  public ResponseEntity<Expense> updateExpense(Long id, Expense expense);

  /**
   * Operation to get an Expense by Id
   * @param id - Id Of Expense
   * @return - {@link Expense}
   */
  @Operation(method = "GET",
    summary = "GET an Expense",
    description = "Make a GET request to fetch an Expense")
  public ResponseEntity<Expense> findExpenseById(Long id);

  /**
   * Operation to get an Expense by Id
   * @param id - Id Of Expense
   * @return - {@link Expense}
   */
  @Operation(method = "GET",
    summary = "GET All Expenses",
    description = "Make a GET request to get All expenses")
  @Parameter(name = "page",
    in = ParameterIn.QUERY,
    description = "Zero-based page index (0..N)",
    content = @Content(schema = @Schema(type = "integer", defaultValue = "0")))
  @Parameter(name = "size",
    in = ParameterIn.QUERY,
    description = "The size of the page to be returned",
    content = @Content(schema = @Schema(type = "integer", defaultValue = "10")))
  @Parameter(name = "sort",
    in = ParameterIn.QUERY,
    description = "Sorting criteria in the format: property(,asc|desc). "
      + "Default sort order is ascending. "
      + "Multiple sort criteria are supported.",
    content = @Content(array = @ArraySchema(schema = @Schema(type = "string"))))
  public ResponseEntity<Page<Expense>> findAllExpenses(@Parameter(hidden = true,
    description = "Use own @Parameters. instead of use the implicit params from Pageable") Pageable pageable);

}
